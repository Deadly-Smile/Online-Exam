package model;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDataBase {
    private static MongoCollection<Document> userCollection;

    private static void connect(){
        MongoClient mongoClient = MongoClients.create(
                "mongodb+srv://Anik:190115@cluster0.y43ax.mongodb.net/Online-Exam?retryWrites=true&w=majority");
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
        Document document = new Document("Exam Name",result.getExamName())
                .append("Maximum Mark",result.getMaximumMark())
                .append("Achieved Mark",result.getAchievedMark());

        FindIterable<Document> iterable = userCollection.find(
                new Document("_id",user.getHandle())
        );
        for (Document i : iterable) {
            userCollection.updateOne(i,new Document("$push",new Document("History",document)));
            break;
        }
    }

    private User getUser(String id){
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
            break;
        }
        if (!b) return null;
        else return user;
    }

    private Document userToDoc(User user){
        Document doc = new Document("Name",user.getName())
                .append("Password",user.getPassword())
                .append("History",historyToDocs(user.getHistory()));
        doc.put("_id",user.getHandle());
        return doc;
    }

    private List<Document> historyToDocs(List<Result> history){
        List<Document> docs = new ArrayList<>();
        for (Result i : history) {
            docs.add(new Document("Exam Name",i.getExamName())
                    .append("Maximum Mark",i.getMaximumMark())
                    .append("Achieved Mark",i.getAchievedMark()));
        }
        return docs;
    }

    private List<Result> docsToHistory(List<Document> docs){
        List<Result> history = new ArrayList<>();
        for (Document i : docs) {
            history.add(new Result(i.get("Exam Name"),
                    i.get("Maximum Mark"),
                    i.get("Achieved Mark")));
        }
        return history;
    }

    public boolean verifyUser(String id,String password) {
        User user = getUser(id);
        if (user == null){
            return false;
        }
        return user.getPassword().equals(password);
    }
}
