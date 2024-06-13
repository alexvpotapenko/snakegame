package com.alex.snake;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import org.w3c.dom.css.Rect;

public class SnakeGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Rectangle snake;

	private ShapeRenderer shapeRenderer;

	private Array<Rectangle> apples;

	private Rectangle tail;

	private Rectangle test;

	private void resetSnake() {
		snake.x = 400;
		snake.y = 240;
	}

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);


		apples = new Array<Rectangle>();

		for (int i = 0; i < 3; i++) {
			apples.add(new Rectangle(MathUtils.random(64f,800f), MathUtils.random(64,480), 20, 20));
		}


		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		snake = new Rectangle();
		snake.height = 20;
		snake.width = 20;
		snake.x = 200;
		snake.y = 100;

		tail = new Rectangle();
		tail.height = snake.height;
		tail.width = snake.width;








	}

	@Override
	public void render () {
		ScreenUtils.clear(0.12f, 0.7f, 0.14f, 0.8f);
		//batch.begin();
		//batch.draw( 0, 0);
		//batch.end();

		tail.x = snake.getX() - snake.getWidth();
		tail.y = snake.getY();

		camera.update();
		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(1,1,0,1);
		shapeRenderer.rect(snake.getX(),snake.getY(),snake.getWidth(),snake.getHeight());
		//shapeRenderer.rect(tail.getX(),tail.getY(),tail.getWidth(),tail.getHeight());
		shapeRenderer.setColor(Color.RED);
		for (int i = 0; i < 3; i++) {
			shapeRenderer.rect(apples.get(i).getX(),apples.get(i).getY(), apples.get(i).getWidth(), apples.get(i).getHeight());
		}

		shapeRenderer.end();

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			snake.x += 500 * Gdx.graphics.getDeltaTime();
		} else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			snake.x -= 500 * Gdx.graphics.getDeltaTime();
		} else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			snake.y += 500 * Gdx.graphics.getDeltaTime();
		} else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			snake.y -= 500 * Gdx.graphics.getDeltaTime();
		}

		if (snake.getX() > 800 || snake.getX() < 0 || snake.getY() > 480 || snake.getY() < 0) {
			resetSnake();
		}

		for (int i = 0; i < 3; i++) {
			if(snake.overlaps(apples.get(i))) {

			}
		}





	}
	
	@Override
	public void dispose () {
		batch.dispose();
		shapeRenderer.dispose();

	}
}
