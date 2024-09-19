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
    private int healingAmount;
    private String image;
    private int cost;


    public Cards(String title, int attack, int healingAmount, String image, int cost) {
        this.title = title;
        this.attack = attack;
        this.healingAmount = healingAmount == 0 ? 0 : healingAmount;
        this.image = image == null ? "Cette carte \nn'a pas d'image" : image;
        this.cost = cost == 0 ? 1 : cost;

    }

    public void show(Stage stage){
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        Texture cardTexture = new Texture(Gdx.files.internal("card_base.png"));
        Drawable cardDrawable = new Image(cardTexture).getDrawable();

        // Créer une image à partir de la texture
        Image cardImage = new Image(cardDrawable);
        // Créer une table pour les informations de la carte
        Table infoTable = new Table();

        Label cardName = new Label(title, skin);
        Label cardPhoto = new Label(image, skin);
        Label cardCost = new Label(cost + "", skin);
        Label cardEffect = new Label("Deal " + attack + " damage, \nrestore " +healingAmount +" health.", skin);


        infoTable.add(cardCost).height(60).growX().getActor().setAlignment(Align.center);
        infoTable.row();
        infoTable.add(cardPhoto).height(90).growX().getActor().setAlignment(Align.center);
        infoTable.row();
        infoTable.add(cardName).height(40).growX().getActor().setAlignment(Align.center);
        infoTable.row();
        infoTable.add(cardEffect).grow().getActor().setAlignment(Align.center);
        infoTable.row();


        final Stack stack = new Stack(cardImage, infoTable);
        stack.setSize(cardImage.getWidth(), cardImage.getHeight());
        stack.setPosition(200,80);
        stage.addActor(stack);
        stage.setDebugAll(true);

        // ou Positionner infoTable sur l'image de la carte comme ça ?
//        infoTable.setPosition(cardImage.getX() + 20, cardImage.getY() + 150); // Ajuster les positions selon les besoins
//    }

        }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealingAmount() {
        return healingAmount;
    }



    public void setHealingAmount(int healingAmount) {
        this.healingAmount = healingAmount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


}


