package model;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class UserDataBase {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> userCollection;
    public UserDataBase() {

        mongoClient = MongoClients.create(
                "mongodb+srv://Anik:190115@cluster0.y43ax.mongodb.net/Online-Exam?retryWrites=true&w=majority");
        database = mongoClient.getDatabase("Online-Exam");
        userCollection = database.getCollection("User");
    }

    public boolean addUser(User user){
        if (!findUser(new Document("_id",user.getHandle()))){
            userCollection.insertOne(userToDoc(user));
            return true;
        }else {
            return false;
        }
    }

    private boolean findUser(Document doc){
//        Document doc = new Document("_id","Deadly_Smile");
        FindIterable<Document> iterable = userCollection.find(doc);
        boolean b = false;
        for (Document ignored : iterable){
            b = true;
            break;
        }
        return b;
    }

    private void removeUser(){

    }

    public void editUser(){

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
            System.out.println(user);
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
}
