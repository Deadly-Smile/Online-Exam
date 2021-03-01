package model;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExamDataBase {
    private static MongoCollection<Document> examCollection;

    private static void connect(){
        MongoClient mongoClient = MongoClients.create(
                "mongodb+srv://Anik:190115@cluster0.y43ax.mongodb.net/Online-Exam?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("Online-Exam");
        examCollection = database.getCollection("Exam");
    }

    public ExamDataBase() {
        connect();
    }

    public boolean addExam(Exam exam){
        if (!findExam(new Document("Exam Id", exam.getId()))){
            examCollection.insertOne(examToDoc(exam));
            return true;
        } else {
            return false;
        }
    }

    private Document examToDoc(Exam exam) {
        Document doc = new Document("Exam Name",exam.getExamName())
                .append("Setter", exam.getExamSetterHandle())
                .append("Password", exam.getExamPassword())
                .append("Starting Time", exam.getExamStartingTime())
                .append("Questions", questionToDocs(exam.getQuestions()))
                .append("Duration", exam.getExamDuration())
                .append("Penalty", exam.getPenalty())
                .append("Passing Percent", exam.getPassingPercent());
        doc.put("_id", exam.getId());
        return doc;
    }

    private Object questionToDocs(ArrayList<MultipleChoiceQuestion> questions) {
        List<Document> docs = new ArrayList<>();
        for (MultipleChoiceQuestion i : questions) {
            docs.add(new Document("Id", i.getId())
                    .append("Question", i.getQuestion())
                    .append("Choices", choicesToDocs(i.getChoices()))
                    .append("Right Index", i.getRightIndex())
                    .append("Mark", i.getMark())
            );
        }
        return docs;
    }

    private Object choicesToDocs(List<String> choices) {
        List<Document> docs = new ArrayList<>();
        for (int i = 0; i < choices.size(); i++) {
            docs.add(new Document(i + "",choices.get(i)));
        }
        return docs;
    }

    private boolean findExam(Document doc){
        boolean b = false;
        FindIterable<Document> iterable = examCollection.find(doc);
        for (Document ignored : iterable){
            b = true;
            break;
        }
        return b;
    }

    public Exam getExam(String id) {
        Document doc = new Document("_id",id);
        FindIterable<Document> iterable = examCollection.find(doc);
        boolean b = false;
        Exam exam = new Exam();
        for (Document document : iterable){
            b = true;
            docToExam(exam, document);
            break;
        }
        if (!b) return null;
        else return exam;
    }

    private void docToExam(Exam exam, Document doc) {
        exam.setId(doc.get("_id").toString());
        exam.setExamName(doc.get("Exam Name").toString());
        exam.setExamSetterHandle(doc.get("Setter").toString());
        exam.setExamPassword(doc.get("Password").toString());
        exam.setExamStartingTime((Date) doc.get("Starting Time"));
        exam.setQuestions(docsToQuestion((List<Document>) doc.get("Questions")));
        exam.setExamDuration((Integer) doc.get("Duration"));
        exam.setPenalty((int) doc.get("Penalty"));
        exam.setPassingPercent((Integer) doc.get("Passing Percent"));
    }

    public List<Exam> getAllExams(){
        List<Exam> examList = new ArrayList<>();
        FindIterable<Document> documents = examCollection.find();
        for (Document document : documents){
            Exam exam = new Exam();
            docToExam(exam,document);
            if (exam.getStatus() == 3) {
                deleteExam(exam.getId());
            } else {
                examList.add(exam);
            }
        }
        return examList;
    }

    private ArrayList<MultipleChoiceQuestion> docsToQuestion(List<Document> documents) {
        ArrayList<MultipleChoiceQuestion> questions = new ArrayList<>();
        for (Document doc : documents) {
            questions.add(new MultipleChoiceQuestion(
                    (int) doc.get("Id"),
                    doc.get("Question").toString(),
                    docsToChoice((List<Document>) doc.get("Choices")),
                    (int) doc.get("Right Index"),
                    (double) doc.get("Mark"))
            );
        }
        return questions;
    }

    private List<String> docsToChoice(List<Document> docs) {
        List<String> choices = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            choices.add(docs.get(i).get(i+"").toString());
        }
        return choices;
    }

    public boolean verifyPass(String id, String password){
        Exam exam = getExam(id);
        if (exam == null){
            return false;
        }
        return exam.getExamPassword().equals(password);
    }

    public void deleteExam (String id) {
        Document doc = new Document("_id",id);
        examCollection.deleteOne(doc);
    }

    public List<Exam> getSearchedExam(String key) {
        List<Exam> exams = new ArrayList<>();
        Exam exam = getExam(key);
        if(exam == null){
            Document doc = new Document("Exam Name",key);
            FindIterable<Document> iterable = examCollection.find(doc);
            boolean b = false;
            for (Document document : iterable){
                if (!b) {
                    b = true;
                }
                Exam newExam = new Exam();
                docToExam(newExam, document);
                exams.add(newExam);
            }
            if (!b) {
                return null;
            }
            else {
                return exams;
            }
        } else {
            exams.add(exam);
            return exams;
        }
    }
}
