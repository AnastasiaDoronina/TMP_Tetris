package Service;

import model.Coord;
import model.Figure;
import model.Mapable;
import ui.Config;
import ui.Window;

public class FlyFigure {
    private Figure figure; // активная фигура
    private Coord coord;
    private boolean landed;
    private int ticks;
    Mapable map;

    public FlyFigure(Mapable map){
        this.map = map;
        figure = Figure.getRandom();
        coord = new Coord (Config.WIDTH / 2 - 2,figure.top.y - figure.bot.y - 1);
        landed = false;
        ticks=2;
    }

    public Figure getFigure(){
        return figure;
    }

    public Coord getCoord(){
        return coord;
    }

    public boolean isLanded(){
        return landed;
    }

    private boolean canMoveFigure (Figure figure, int sx, int sy) {
        if (coord.x + sx + figure.top.x < 0) return false;
        if (coord.x + sx + figure.bot.x >= Config.WIDTH) return false;
        //if (coord.y + sy + figure.top.y < 0) return false;
        if (coord.y + sy + figure.bot.y >= Config.HEIGHT) return false;
        for(Coord dot : figure.dots){
            if(map.getBoxColor(coord.x + dot.x + sx, coord.y + dot.y + sy) != 0)
                return false;
        }
        return true;
    }
    public void moveFigure( int sx, int sy) {
        if(canMoveFigure(figure,sx,sy)) {
            coord = coord.plus(sx,sy);
        }
        else
            if(sy==1){
                if(ticks > 0)
                    ticks --;
                else
                    landed=true;

        }
    }

    public void turnFigure(int direction){
        Figure rotated = direction == 1 ? figure.turnRight() : figure.turnLeft();
        if(!canMoveFigure(rotated,0,0)) return;
        figure = rotated;
    }
}
