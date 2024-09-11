package com.perjetperso.jajaaventure;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.awt.*;



/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private Stage stage;
    private Skin buttonSkin;
    private TextButton buttonStart;
    private TextButton buttonQuit;
    private TextButton buttonCardsList;
    private TextButton buttonMyCards;
    private boolean gameStarted;
    private boolean showAllCards;
    private boolean showMyCards;

    private OrthographicCamera camera;

    @Override
    public void create() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Skin buttonSkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 640, 480);

        TextButton buttonCardsList = new TextButton("All Cards",buttonSkin,"small");
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

        TextButton buttonMyCards = new TextButton("My Cards",buttonSkin,"small");
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

        TextButton buttonStart = new TextButton("Start",buttonSkin,"small");
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

        TextButton buttonQuit = new TextButton("Quit",buttonSkin,"small");
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
    }


    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        if(showAllCards){
            Stage stageAllCards = new Stage(new ScreenViewport());
            Gdx.input.setInputProcessor(stageAllCards);
            ScreenUtils.clear(217/ 255f, 142/ 255f, 4/ 255f, 1);
            Cards the_first_card = new Cards("\n\nmy first card",1,1,"this is my first card\n in Jaja Aventure");
            the_first_card.show(stageAllCards);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            stageAllCards.act(Gdx.graphics.getDeltaTime());
            stageAllCards.draw();
        }
        if(showMyCards){

        }
        if(gameStarted){
            ScreenUtils.clear(217/ 255f, 142/ 255f, 4/ 255f, 1);
        }




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
