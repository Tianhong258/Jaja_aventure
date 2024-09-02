package com.perjetperso.jajaaventure;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Value;
import com.badlogic.gdx.utils.Align;

import static com.badlogic.gdx.scenes.scene2d.ui.Table.Debug.table;

public class Cards {
    private String title;
    private int attack;
    private int cost;
    private String description;


    public static void createCard(String title, int attack, int cost, String description){
            Table table = new Table();
        BackgroundColor background = new BackgroundColor("card_base.png",3,60,80,160);
        table.setBackground(background);
            /* Adds the "Cost" label and centers its text. */
            table.add("Cost").width(75).height(75).getActor().setAlignment(Align.center);
            /* Important! Adds a column between "Cost" and "S". Used to
             * align "Image", "Title", "Description", and "Class". */
            table.add();
            /* Same as "Cost". */
            table.add("S").width(75).height(75).getActor().setAlignment(Align.center);
            table.row();

            /* Add "Image" to middle column with a height of 50% of the
             * background's height minus 75 (the top columns height). */
            table.add();
            table.add("Image").growX().height(80 - 75)
                .getActor().setAlignment(Align.center);
            table.add();
            table.row();

            /* Add "Title".*/
            table.add();
            table.add("Title").grow().getActor().setAlignment(Align.center);
            table.add();
            table.row();

            /* Add "Description". */
            table.add();
            table.add("Description").grow().getActor().setAlignment(Align.center);
            table.add();
            table.row();

            /* Add "Life", "Class", and "Attack". Same deal as "Cost" and
             * "S" */
            table.add("Life").width(75).height(75).getActor().setAlignment(Align.center);
            table.add("Class").growX().fillY().getActor().setAlignment(Align.center);
            table.add("Attack").width(75).height(75).getActor().setAlignment(Align.center);

            /* Used to show the table above the background image. You
             * should probably use Table#setBackground(drawable)
             * instead of using a stack! */
//            final Stack stack = new Stack(background, table);
//            stack.setSize(background.getWidth(), background.getHeight());
//        Stage stage = null;
//        stage.addActor(stack);

            /*Shows the green and red outlines. ONLY FOR DEBUGGING!*/
            //stage.setDebugAll(true);
        }
}


