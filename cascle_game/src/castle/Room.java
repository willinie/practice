package castle;

public class Room {
    private String description;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;

    public Room(String description) 
    {
        this.description = description;
    }

    public void setExits(Room north, Room east, Room south, Room west) 
    {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
    }

    @Override
    public String toString()
    {
        return description;
    }

    public String getExitDescription(){
        StringBuffer sb = new StringBuffer();
        if(northExit != null)
            sb.append("north ");
        if(southExit != null)
            sb.append("south ");
        if(eastExit != null)
            sb.append("east ");
        if(westExit != null)
            sb.append("west ");
        return sb.toString();
    }

    public Room getExit(String direction){
        switch (direction) {
            case "north" -> {
                return northExit;
            }
            case "south" -> {
                return southExit;
            }
            case "east" -> {
                return eastExit;
            }
            case "west" -> {
                return westExit;
            }
        }
        return null;
    }
}
