package com.perjetperso.jajaaventure;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Align;


public class Cards {
    private String title;
    private int attack;
    private int cost;
    private String description;

    public Cards(String title, int attack, int cost, String description) {
        this.title = title;
        this.attack = attack;
        this.cost = cost;
        this.description = description;
    }

    public void show(Stage stage){
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        Table cardTable = new Table();

        Texture cardTexture = new Texture(Gdx.files.internal("card_base.png"));
        Drawable cardDrawable = new Image(cardTexture).getDrawable();

        // Créer une image à partir de la texture
        Image cardImage = new Image(cardDrawable);



        // Créer une table pour les informations de la carte
        Table infoTable = new Table();

        Label cardName = new Label(title, skin);
        Label cardDescription = new Label(description, skin);
        Label cardCost = new Label(cost + "", skin);
        Label cardAttack = new Label(attack + "", skin);

        infoTable.add(cardCost).height(75).growX().getActor().setAlignment(Align.left);
        infoTable.row();
            /* Add "Image" to middle column with a height of 50% of the
             * background's height minus 75 (the top columns height). */
        infoTable.row();
            /* Add "Title".*/
        infoTable.add(cardName).grow().getActor().setAlignment(Align.center);
        infoTable.row();
            /* Add "Description". */
        infoTable.add(cardDescription).grow().getActor().setAlignment(Align.center);
        infoTable.row();

        final Stack stack = new Stack(cardImage, infoTable);
        stack.setSize(cardImage.getWidth(), cardImage.getHeight());
        stage.addActor(stack);
        stage.setDebugAll(true);
        //stage.addActor(cardImage); // Ajouter l'image en premier (arrière-plan)
        //stage.addActor(infoTable);

        // ou Positionner infoTable sur l'image de la carte comme ça ?
//        infoTable.add(costLabel).expandX().left().pad(10);
//        infoTable.row(); // Aller à la ligne suivante
//        infoTable.add(descriptionLabel).expandX().left().pad(10);
//        infoTable.setPosition(cardImage.getX() + 20, cardImage.getY() + 150); // Ajuster les positions selon les besoins
//    }

        }
}


