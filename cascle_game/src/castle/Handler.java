package castle;

public class Handler {
    protected Game game;
    public Handler(Game game){
        this.game = game;
    }
    public void doCommand(String command) {

    }
    public boolean isBye(){
        return false;
    }
}

