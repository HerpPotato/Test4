package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import javafx.scene.image.Image;

/*
    Base class for all drawable objects (they extend from here)
    Contains sprite HashMap and objectState, which is the key
    loadImages must be called in order to load the sprites
 */

public class Drawable
{
    private ObjectState objectState;
    transient HashMap<ObjectState, Image> sprites = new HashMap<>();

    public Image getSprite()
    {
        return sprites.get(objectState);
    }

    public ObjectState getObjectState()
    {
        return objectState;
    }

    public void setObjectState(ObjectState objectState)
    {
        this.objectState = objectState;
    }

    //temp variables is use in order to 'simulate' the key for each image, and also to get the toString()
    public void loadImages(String name)
    {
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                ObjectState tempObjectState = new ObjectState(i, j);
                sprites.put(tempObjectState, loadImage(name + "/" + tempObjectState.toString()+ ".png"));
            }
        }
    }

    //loads an image from /res/sprites/folderAndFileName
    public Image loadImage(String folderAndFileName)
    {
        InputStream inputStream = null;
        try
        {
            inputStream = new FileInputStream(new File("./res/Sprites/" + folderAndFileName));
        }
        catch (FileNotFoundException e)
        {
        }
        if (inputStream == null)
            return null;
        return new Image(inputStream);
    }
}