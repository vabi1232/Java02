package Love_O;
import java.util.ArrayList;
public class LoveOldList {
    private String myName,myCharacter;
    private ArrayList <LoveOld>myLoveOlds;
    public LoveOldList (String myName){
        this.myName=myName;
        this.myLoveOlds= new ArrayList<LoveOld>();
    }
    private int findLoveOld(String oldLoveName){
        for (int i=0;i<this.myLoveOlds.size();i++){
            LoveOld loveOld= this.myLoveOlds.get(i);
            if (loveOld.getName().equals(oldLoveName)){
                return i;
            }
        }
        return 0;
    }
    private int findLoveOld(LoveOld loveOld){
        return this.myLoveOlds.indexOf(loveOld);
    }
    //add Old Love
    public boolean addNewOldLove(LoveOld loveOld){
        if (findLoveOld(loveOld.getName())>=0){
            System.out.println("Người yêu cũ đã có trong danh sách");
            return false;
        }
        myLoveOlds.add(loveOld);
        return true;
    }
    public boolean updateLoveOld(LoveOld oldlove,LoveOld newoldlove){
        int foundPosition = findLoveOld(oldlove);
        if (foundPosition<0){
            System.out.println(oldlove.getName()+", was not found.");
            return false;
        }
        this.myLoveOlds.set(foundPosition,newoldlove);
        System.out.println(oldlove.getName()+", was replaced with"+newoldlove.getName());
        return true;
    }
    public boolean removeLoveOld(LoveOld loveOld){
        int foundPosition = findLoveOld(loveOld);
        if (foundPosition<0){
            System.out.println(loveOld.getName()+"was not found");
            return false;
        }
        this.myLoveOlds.remove(foundPosition);
        System.out.println(loveOld.getName()+"was deleted.");
        return true;
    }
    public LoveOld queryLoveOld(String name){
        int position = findLoveOld(name);
        if (position>=0){
            return this.myLoveOlds.get(position);
        }
        return null;
    }
    public void printLoveOlds(){
        System.out.println("Love Old List "+myName+","+myCharacter);
        for (int i=0;i<this.myLoveOlds.size();i++){
            System.out.println(i+1+" . "+this.myLoveOlds.get(i).getName()+" -> "+this.myLoveOlds.get(i).getCharacter());
        }
    }
}
