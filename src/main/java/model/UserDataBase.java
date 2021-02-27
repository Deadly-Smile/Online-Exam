package model;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDataBase {
    private static MongoCollection<Document> userCollection;

    private static void connect() {
        MongoClient mongoClient = MongoClients.create(
                "mongodb+srv://Anik:190115@cluster0.y43ax.mongodb.net" +
                        "/Online-Exam?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("Online-Exam");
        userCollection = database.getCollection("User");
    }

    public UserDataBase() {
        connect();
    }

    public boolean addUser(User user){
        if (!findUser(new Document("_id",user.getHandle()))){
            userCollection.insertOne(userToDoc(user));
            return true;
        } else {
            return false;
        }
    }

    private boolean findUser(Document doc){
        boolean b = false;
        FindIterable<Document> iterable = userCollection.find(doc);
        for (Document ignored : iterable){
            b = true;
            break;
        }
        return b;
    }

    public void addResultToUser(Result result, User user){
        Document document = resultToDoc(result);
        FindIterable<Document> iterable = userCollection.find(
                new Document("_id",user.getHandle())
        );
        for (Document i : iterable) {
            userCollection.updateOne(i,
                    new Document("$push",new Document("History",document)));
            break;
        }
    }

    private Document resultToDoc(Result result) {
        return new Document(
                "Exam Id",result.getExamId())
                .append("Exam Name",result.getExamName())
                .append("Maximum Mark",result.getMaximumMark())
                .append("Achieved Mark",result.getAchievedMark())
                .append("Penalty",result.getPenalty())
                .append("Exam Start Time",result.getExamStartTime())
                .append("Exam Setter",result.getExamSetter())
                .append("Number Of Question",result.getNumberOfQuestion())
                .append("Exam Duration",result.getExamDuration())
                .append("Is Passed",result.isPassed())
                .append("Right Answered",result.getRightAnswered())
                .append("Wrong Answered",result.getWrongAnswered())
                .append("Not Answered",result.getNotAnswered()
                );
    }

    public void addExamToUser(ExamInfo createdExam, User user){
        Document document = new Document(
                "Exam Name",createdExam.getExamName())
                .append("Exam Id",createdExam.getExamID())
                .append("Starting Time",createdExam.getStartingTime())
                .append("Duration",createdExam.getExamDuration()
        );
        FindIterable<Document> iterable = userCollection.find(
                new Document("_id",user.getHandle())
        );
        for (Document i : iterable) {
            userCollection.updateOne(i,
                    new Document("$push",new Document("Created Exam",document)));
            break;
        }
    }

    public User getUser(String id){
        Document doc = new Document("_id",id);
        FindIterable<Document> iterable = userCollection.find(doc);
        boolean b = false;
        User user = new User();
        for (Document document : iterable){
            b = true;
            user.setHandle(document.get("_id").toString());
            user.setName(document.get("Name").toString());
            user.setPassword(document.get("Password").toString());
            user.setHistory(docsToHistory((List<Document>) document.get("History")));
            user.setCreatedExams(docToExamInfo((List<Document>) document.get("Created Exam")));
            break;
        }
        if (!b) return null;
        else return user;
    }

    private Document userToDoc(User user){
        Document doc = new Document("Name",user.getName())
                .append("Password",user.getPassword())
                .append("History",historyToDocs(user.getHistory()))
                .append("Created Exam",examInfoToDocs(user.getCreatedExams()));

        doc.put("_id",user.getHandle());
        return doc;
    }

    private List<Document> historyToDocs(List<Result> history){
        List<Document> docs = new ArrayList<>();
        for (Result i : history) {
            docs.add(resultToDoc(i));
        }
        return docs;
    }

    private List<Document> examInfoToDocs(List<ExamInfo> createdExam) {
        List<Document> docs = new ArrayList<>();
        for (ExamInfo i : createdExam) {
            docs.add(new Document("Exam Name",i.getExamName())
                    .append("Exam Id",i.getExamID())
                    .append("Starting Time",i.getStartingTime())
                    .append("Duration",i.getExamDuration()));
        }
        return docs;
    }

    private List<Result> docsToHistory(List<Document> docs){
        List<Result> history = new ArrayList<>();
        for (Document i : docs) {
            history.add(
                    new Result((String)i.get("Exam Id"),
                            (String)i.get("Exam Name"),
                            (double)i.get("Maximum Mark"),
                            (double)i.get("Achieved Mark"),
                            (int)i.get("Penalty"),
                            (Date)i.get("Exam Start Time"),
                            (String)i.get("Exam Setter"),
                            (int)i.get("Number Of Question"),
                            (int)i.get("Exam Duration"),
                            (boolean)i.get("Is Passed"),
                            (int)i.get("Right Answered"),
                            (int)i.get("Wrong Answered"),
                            (int)i.get("Not Answered"))
            );
        }
        return history;
    }

    private List<ExamInfo> docToExamInfo(List<Document> docs) {
        List<ExamInfo> createdExams = new ArrayList<>();
        for (Document i : docs) {
            createdExams.add(
                    new ExamInfo(i.get("Exam Name"),
                    i.get("Exam Id"),
                    i.get("Starting Time"),
                    i.get("Duration"))
            );
        }
        return createdExams;
    }

    public boolean verifyUser(String id,String password) {
        User user = getUser(id);
        if (user == null){
            return false;
        }
        return user.getPassword().equals(password);
    }
}
