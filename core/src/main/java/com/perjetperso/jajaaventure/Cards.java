package com.perjetperso.jajaaventure;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Align;



public class Cards extends Actor {
    private String title;
    private int attack;
    private int healingAmount;
    private String image;
    private int cost;

    private boolean isChosen;

    public Cards(String title, int attack, int healingAmount, String image, int cost) {
        this.title = title;
        this.attack = attack;
        this.healingAmount = healingAmount;
        this.image = image == null ? "Cette carte \nn'a pas d'image" : image;
        this.cost = cost;
        this.isChosen = false;
        };


    public void show(Stage stage, int X,int Y){
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        skin.getFont("default-font").getData().setScale(0.85f);
        Pixmap textureOrigine = new Pixmap(Gdx.files.internal("card_base.png"));
        Pixmap textureCard = new Pixmap(138, 180, textureOrigine.getFormat());
        textureCard.drawPixmap(textureOrigine,
            0, 0, textureOrigine.getWidth(), textureOrigine.getHeight(),
            0, 0, textureCard.getWidth(), textureCard.getHeight()
        );
        Texture cardTexture = new Texture(textureCard);
        textureOrigine.dispose();
        textureCard.dispose();
        Drawable cardDrawable = new Image(cardTexture).getDrawable();

        // Créer une image à partir de la texture
        Image cardImage = new Image(cardDrawable);
        // Créer une table pour les informations de la carte
        Table infoTable = new Table();

        Label cardName = new Label(title, skin);
        Label cardPhoto = new Label(image, skin);
        Label cardCost = new Label(cost + "", skin);
        Label cardEffect = new Label("Deal " + attack + " damage, \nrestore " + healingAmount +" health.", skin);

        infoTable.add(cardCost).height(30).growX().getActor().setAlignment(Align.left);
        infoTable.row();
        infoTable.add(cardPhoto).height(48).growX().getActor().setAlignment(Align.center);
        infoTable.row();
        infoTable.add(cardName).height(22).growX().getActor().setAlignment(Align.center);
        infoTable.row();
        infoTable.add(cardEffect).grow().getActor().setAlignment(Align.center);
        infoTable.row();
        final Stack stack = new Stack(cardImage, infoTable);
        stack.setSize(cardImage.getWidth(), cardImage.getHeight());
        stack.setPosition(X,Y);
        stack.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                // Quand on clique sur la carte, on change son état
                System.out.println("Card is clicked!");

                // Dessiner un cadre blanc autour de la carte
                ShapeRenderer shapeRenderer = new ShapeRenderer();
                shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
                shapeRenderer.setColor(Color.RED);

                // Récupérer la position et les dimensions de la carte
                float cardX = getX();
                float cardY = getY();

                // Dessiner le rectangle autour de la carte (ajustement du cadre)
                shapeRenderer.rect(cardX - 5, cardY - 5, 148, 190);
                shapeRenderer.end();

                // Changer l'état de la carte
                isChosen = !isChosen;

                return true;
            }
        });
        stage.addActor(stack);
        stage.setDebugAll(true);
    }
    public void chosen(Stage stage, int X, int Y) {
        // Inverser l'état de isChosen
        isChosen = !isChosen;

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


