package com.mygdx.Core.client;

import snake.engine.core.SnakeStart;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

/*                               Developed By:
 *                                  NoDark
 *                               sessaGlasses
 *  Module: Mr.Strings -- auto-generated
 */

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(480, 320);
        }

        @Override
        public ApplicationListener getApplicationListener () {
                return new SnakeStart();
        }
}