/*
 * ******************************************************************************
 *  * Copyright 2015 See AUTHORS file.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *   http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *  *****************************************************************************
 */

package com.uwsoft.editor.mvc.proxy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.puremvc.patterns.proxy.BaseProxy;
import com.uwsoft.editor.ui.widget.CursorData;

/**
 * Created by azakhary on 5/15/2015.
 */
public class CursorManager extends BaseProxy {
    private static final String TAG = CursorManager.class.getCanonicalName();
    public static final String NAME = TAG;

    public static CursorData CROSS = new CursorData("cross", 0, 0);
    public static CursorData TEXT = new CursorData("eyedropper", 0, 0);

    private CursorData cursor;
    private CursorData overrideCursor = null;

    public CursorManager() {
        super(NAME);

        setCursor(CROSS);
    }

    public void setCursor(CursorData cursor) {
        this.cursor = cursor;
        setCursorPixmap();
    }

    public void setOverrideCursor(CursorData cursor) {
        overrideCursor = cursor;
        setCursorPixmap();
    }

    private void setCursorPixmap() {
        CursorData currentCursor = overrideCursor;
        if(currentCursor == null) {
            currentCursor = cursor;
        }

        Pixmap pm = new Pixmap(Gdx.files.internal("cursors/" + currentCursor.region + ".png"));
        Gdx.input.setCursorImage(pm, cursor.getHotspotX(), currentCursor.getHotspotY());
        pm.dispose();
    }
}
