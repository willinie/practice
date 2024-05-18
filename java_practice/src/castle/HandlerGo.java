package castle;

public class HandlerGo extends Handler {
    public HandlerGo(Game game) {
        super(game);
    }

    @Override
    public void doCommand(String direction) {
        game.goRoom(direction);
    }
}
