package Love_O;

public class LoveOld {
    private String name,character;

    public LoveOld(String name, String character) {
        this.name = name;
        this.character = character;
    }

    public String getName() {
        return name;
    }

    public String getCharacter() {
        return character;
    }
    public static LoveOld createOldLove(String name,String character){
        return new LoveOld(name,character);
    }
}
