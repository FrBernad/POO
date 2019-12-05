package game.backend.cell;

import game.backend.Grid;
import game.backend.element.*;
import game.backend.level.Level3;

public class TimedBombCandyGeneratorCell extends CandyGeneratorCell {

        private static final double THRESHOLD=0.1;
        private static int MAX_CANDIES = 10;
        private int candiesToThrow = MAX_CANDIES;

        public TimedBombCandyGeneratorCell(Grid grid) {
                super(grid);
        }

        private boolean canThrow() {
            return candiesToThrow>0;
        }

        @Override
        public Element getContent() {
            int i = (int) (Math.random() * CandyColor.values().length);
            int movements = (int) (Math.random() * 10) + 5;
            double j = Math.random();

            if(canThrow()){
                if (j < THRESHOLD) {
                    Candy aux = new TimedBombCandy(CandyColor.values()[i], movements);
                    ((Level3) grid).add(aux);
                    candiesToThrow--;
                    return aux;
                }
            }

            return new Candy(CandyColor.values()[i]);
        }

        public void reset()
        {
            candiesToThrow=MAX_CANDIES;
        }
}