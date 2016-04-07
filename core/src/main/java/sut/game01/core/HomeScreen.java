package sut.game01.core;


import static playn.core.PlayN.*;

import playn.core.*;
import playn.core.ImageLayer;

import tripleplay.game.Screen;
import react.UnitSlot;
import tripleplay.game.UIScreen;
import tripleplay.game.ScreenStack;
import tripleplay.ui.*;
import tripleplay.ui.layout.AxisLayout;
import static playn.core.PlayN.graphics;


public class HomeScreen extends Screen  {

  private final TestScreen testScreen;
  private final ScreenStack ss;
  private final ImageLayer bg;
  private final ImageLayer startButton;
  private Root root;

  public HomeScreen(final ScreenStack ss){
    this.ss = ss;
    this.testScreen =new TestScreen(ss);
    Image bgImage = assets().getImage("images/bg.png");
    this.bg = graphics().createImageLayer(bgImage);
    

    Image startImage = assets().getImage("images/start.png");
    this.startButton = graphics().createImageLayer(startImage);
    startButton.setTranslation(10, 10);
    
    startButton.addListener(new Mouse.LayerAdapter(){
      @Override
      public void onMouseUp(Mouse.ButtonEvent event){
        ss.push(testScreen); 
      }
    });

  }

  //=============================================================
  @Override
  public void wasShown (){
    super.wasShown();
    this.layer.add(bg);
    this.layer.add(startButton);
      PlayN.keyboard().setListener(new Keyboard.Adapter(){
          @Override
          public void onKeyUp(Keyboard.Event event){
              if (event.key() == Key.ENTER){
                  ss.push(testScreen);
              }
          }
      });
  
  }
}