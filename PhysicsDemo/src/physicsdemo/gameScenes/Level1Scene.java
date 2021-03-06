package physicsdemo.gameScenes;

import physicsdemo.GameRect;

import physicsdemo.GameWindow;
import physicsdemo.SpriteRenderer;
import physicsdemo.controller.BackGround;
import physicsdemo.controller.ControllerManager;
import physicsdemo.controller.LeftRightBehavior;
import physicsdemo.cows.Cow;
import physicsdemo.cows.Milk;
import physicsdemo.enemies.EnemyController;
import physicsdemo.enemies.SecondEnemyController;
import physicsdemo.obstacles.Ground;
import physicsdemo.obstacles.MilkBottle;
import physicsdemo.utils.Utils;
import physicsdemo.view.Animation;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by trongphuong1011 on 5/11/2017.
 */
public class Level1Scene implements GameScenes {
    private Image image, image1;
    private Animation animation;

    public static Level1Scene instance;
    public ArrayList<Milk> milks = new ArrayList<>();
    SpriteRenderer spriteRenderer = new SpriteRenderer("res/coww/cow-right-1.png");
    public Cow cow = new Cow(new GameRect(50, 20, spriteRenderer.getImage().getWidth(null), spriteRenderer.getImage().getHeight(null)), spriteRenderer);
//    public BackGround background_1, background_2, background_3, background_4;

    public Level1Scene() {
//        instance = this;
        cow.setMilks(milks);


        new Ground(new GameRect(0, 600, 770, 100), new SpriteRenderer("res/ground/ground0.png"), null);
        new Ground(new GameRect(900, 600, 400, 100), new SpriteRenderer("res/ground/ground01.png"), null);
        new Ground(new GameRect(1120, 500, 200, 200), new SpriteRenderer("res/ground/ground111.png"), null);
        new Ground(new GameRect(1500, 400, 150, 50), new SpriteRenderer("res/ground/ground3.png"), new LeftRightBehavior());
        new Ground(new GameRect(1920, 600, 1400, 100), new SpriteRenderer("res/ground/ground10.png"), null);
        new Ground(new GameRect(2200, 520, 230, 100), new SpriteRenderer("res/ground/ground11.png"), null);
        new Ground(new GameRect(2650, 522, 230, 100), new SpriteRenderer("res/ground/ground11.png"), null);
        new Ground(new GameRect(3100, 520, 226, 100), new SpriteRenderer("res/ground/ground11.png"), null);
        new Ground(new GameRect(3500, 450, 150, 50), new SpriteRenderer("res/ground/ground3.png"), null);
        new Ground(new GameRect(3700, 350, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(3900, 450, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(4200, 350, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(4400, 250, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(4600, 350, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(4800, 450, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(5100, 350, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(5450, 450, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(5800, 500, 400, 200), new SpriteRenderer("res/ground/ground111.png"), null);
        new MilkBottle(new GameRect(6000, 400, 50, 100), new SpriteRenderer("res/milkbottle/milkbottle.png"));

        image = Utils.loadImage("res/SCREEN/background3.png");
        EnemyController enemyController1 = new EnemyController(new GameRect(900, -10, 50, 60), new SpriteRenderer("res/Dragon-Scaled/Minh/run-left-1.png"));
        EnemyController enemyController2 = new EnemyController(new GameRect(50, -10, 50, 60), new SpriteRenderer("res/Minh/run-left-3.png"));
        enemyController1.setShootEnable(false);
        ControllerManager.instance.add(enemyController1);
        ControllerManager.instance.add(enemyController2);
        for (int i = 3200; i <= 4000; i += 800) {
            SecondEnemyController secondEnemyController = new SecondEnemyController(new GameRect(i, 50, 50, 50), new SpriteRenderer("res/Bat/bat-left-1.png"));
            ControllerManager.instance.add(secondEnemyController);
        }

        for (int i = 2450; i <= 2900; i += 450) {
            EnemyController enemyController = new EnemyController(new GameRect(i, 10, 50, 50), new SpriteRenderer("res/Dragon-Scaled/Minh/run-left-1.png"));
            enemyController.setShootEnable(false);
            ControllerManager.instance.add(enemyController);
        }
        GameWindow.instance.clip = Utils.playSound("res/music/level1-1.wav", true);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(image, 0, 0, 1000, 800, null);
    }

    @Override
    public void update() {
    }
}
