package com.perjetperso.jajaaventure;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;
import java.util.List;


/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private Stage stage;
    private Stage stageAllCards;
    private Stage stageNewRoundGame;
    private Skin buttonSkin;
    private TextButton buttonStart;
    private TextButton buttonQuit;
    private TextButton buttonCardsList;
    private TextButton buttonMyCards;
    private TextButton buttonPlayCard;
    private boolean gameStarted;
    private boolean showAllCards;
    private boolean showMyCards;
    private boolean playCard;
    private OrthographicCamera camera;
    private int gamerHealth;
    private int monsterHealth;
    private BitmapFont bitmapFontHealth;
    private SpriteBatch spriteBatchHealth;
    private List<Cards> allCards;

    @Override
    public void create() {
        //création du menu
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 640, 480);

        //création les boutons du menu
        buttonSkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        buttonCardsList = new TextButton("All Cards",buttonSkin,"small");
        buttonCardsList.setSize(140,50);//(col_width*4,row_height);
        buttonCardsList.setPosition(240,180);//(col_width*7,Gdx.graphics.getHeight()-row_height*3);
        buttonCardsList.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Press a Button");
                //camera.update();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Pressed Text Button");
                showAllCards = true;
                return true;
            }
        });
        stage.addActor(buttonCardsList);

        buttonMyCards = new TextButton("My Cards",buttonSkin,"small");
        buttonMyCards.setSize(140,50);//(col_width*4,row_height);
        buttonMyCards.setPosition(240,110);//(col_width*7,Gdx.graphics.getHeight()-row_height*3);
        buttonMyCards.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Press a Button");

                //camera.update();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Pressed Text Button");
                showMyCards = true;
                return true;
            }
        });
        stage.addActor(buttonMyCards);
        buttonStart = new TextButton("Start",buttonSkin,"small");
        buttonStart.setSize(140,50);//(col_width*4,row_height);
        buttonStart.setPosition(240,320);//(col_width*7,Gdx.graphics.getHeight()-row_height*3);
        buttonStart.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Press a Button");

                //camera.update();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Pressed Text Button");
                gameStarted = true;
                return true;
            }
        });
        stage.addActor(buttonStart);

        buttonQuit = new TextButton("Quit",buttonSkin,"small");
        buttonQuit.setSize(140,50);//(col_width*4,row_height);
        buttonQuit.setPosition(240,250);//(col_width*7,Gdx.graphics.getHeight()-row_height*3);
        buttonQuit.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Press a Button");

            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Pressed Text Button");
                return true;
            }
        });
        stage.addActor(buttonQuit);

        //création de la stage de l'écran pour afficher toutes les cartes du jeu
        stageAllCards = new Stage(new ScreenViewport());

        //création de l'écran pour afficher une nouvelle partie du jeu
        stageNewRoundGame = new Stage(new ScreenViewport());

        gamerHealth = 70;
        monsterHealth = 20;
        bitmapFontHealth = new BitmapFont();
        spriteBatchHealth = new SpriteBatch();

        buttonPlayCard = new TextButton("Play this card",buttonSkin,"small");
        buttonPlayCard.setSize(140,50);//(col_width*4,row_height);
        buttonPlayCard.setPosition(260,30);//(col_width*7,Gdx.graphics.getHeight()-row_height*3);
        buttonPlayCard.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //outputLabel.setText("Press a Button");
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                playCard = true;
                //outputLabel.setText("Pressed Text Button");
                return true;
            }
        });
        //création de toutes les cartes dans le jeu
        Cards attack = new Cards("attack",1,0,null,1);
        Cards heal = new Cards("heal",0,1,null,1);
        Cards destory = new Cards("destory",1,1,null,1);
        allCards = new ArrayList<>();
        allCards.add(attack);
        allCards.add(heal);
        allCards.add(destory);

    }


    @Override
    public void render(){
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        if(showAllCards){
            Gdx.input.setInputProcessor(stageAllCards);
            ScreenUtils.clear(217/ 255f, 142/ 255f, 4/ 255f, 1);
            Cards the_first_card = new Cards("my first card",1,1,null, 1);
            the_first_card.show(stageAllCards, 200,80);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            stageAllCards.act(Gdx.graphics.getDeltaTime());
            stageAllCards.draw();
        }
        if(showMyCards){

        }
        if(gameStarted){
            Gdx.input.setInputProcessor(stageNewRoundGame);
            ScreenUtils.clear(217/ 255f, 142/ 255f, 4/ 255f, 1);
            Cards the_first_card = new Cards("my first card",1,1,null, 1);
            allCards.get(0).show(stageNewRoundGame,100,80);
            allCards.get(1).show(stageNewRoundGame, 250,80);
            allCards.get(2).show(stageNewRoundGame,400,80);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            //afficher les cartes et le bouton pour jouer une carte
            stageNewRoundGame.act(Gdx.graphics.getDeltaTime());
            stageNewRoundGame.addActor(buttonPlayCard);//detecter laquel carte est cliquée
            stageNewRoundGame.draw();

            //afficher les PV du joueur et du monstre
            spriteBatchHealth.begin();
            bitmapFontHealth.setColor(1.0f, 1.0f, 1.0f, 1.0f);
            bitmapFontHealth.draw(spriteBatchHealth, "" + gamerHealth, 80, 200);
            bitmapFontHealth.draw(spriteBatchHealth, "" + monsterHealth, 550, 200);
            spriteBatchHealth.end();

            if(playCard){
                gamerHealth += the_first_card.getHealingAmount();
                monsterHealth -= the_first_card.getAttack();
                playCard = false;
            };




        };




//        batch.begin();
//        batch.draw(image, 140, 210);
//        batch.end();
    }



    @Override
    public void dispose() {
//        batch.dispose();
//        image.dispose();
    }
}
