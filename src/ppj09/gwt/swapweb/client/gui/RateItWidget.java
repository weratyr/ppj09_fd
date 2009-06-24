package ppj09.gwt.swapweb.client.gui;

/*
RateIt Widget for GWT
Copyright (C) 2006 Alexei Sokolov http://gwt.components.googlepages.com/

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA

*/ 

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.ChangeListenerCollection;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.KeyboardListener;
import com.google.gwt.user.client.ui.KeyboardListenerAdapter;
import com.google.gwt.user.client.ui.MouseListenerAdapter;
import com.google.gwt.user.client.ui.SourcesChangeEvents;
import com.google.gwt.user.client.ui.Widget;

public class RateItWidget extends Composite implements SourcesChangeEvents {

  private static class RatePanel extends Image {
    private int rating;

    public RatePanel(int rating, Image anotherImage) {
      super(anotherImage.getUrl());
      this.rating = rating;
    }

    public int getRating() {
      return rating;
    }

    public void replaceImage(Image newWidget) {
      this.setUrl(newWidget.getUrl());
    }
  }

  private static class CellMouseListener extends MouseListenerAdapter {
    private RateItWidget rateItWidget;

    public CellMouseListener(RateItWidget rateItWidget) {
      this.rateItWidget = rateItWidget;
    }

    public void onMouseEnter(Widget sender) {
      rateItWidget.drawRating(((RatePanel) sender).getRating());
    }
  }

  private static class CellClickListener implements ClickListener {

    private RateItWidget rateItWidget;

    public CellClickListener(RateItWidget rateItWidget) {
      this.rateItWidget = rateItWidget;
    }

    public void onClick(Widget sender) {
      rateItWidget.setUserRating(((RatePanel) sender).getRating(), true);
    }
  }

  private Grid grid;

  private Image normalImage;
  private Image normalZeroImage;
  private Image ratedImage;
  private Image ratedZeroImage;
  private Image[] ratingImages;

  private int userRating;

  private ChangeListenerCollection changeListeners;

  private boolean rated = false;

  private double rating;

  private CellMouseListener cellMouseListener = new CellMouseListener(this);
  private CellClickListener cellClickListener = new CellClickListener(this);

  public RateItWidget(double rating, int maxRating, Image normalImage,
      Image ratedImage, Image normalZeroImage, Image ratedZeroImage,
      Image ratingImage) {
    this(rating, maxRating, normalImage, ratedImage, normalZeroImage,
      ratedZeroImage, new Image[] { ratingImage });
  }

  public RateItWidget(double rating, int maxRating, Image normalImage,
      Image ratedImage, Image normalZeroImage, Image ratedZeroImage,
      Image[] ratingImages) {
    FocusPanel panel = new FocusPanel();
    panel.addMouseListener(new MouseListenerAdapter() {
      public void onMouseLeave(Widget sender) {
        if (isRated()) {
          drawRating(getUserRating());
        } else {
          setup();
        }
      }
    });
    panel.addKeyboardListener(new KeyboardListenerAdapter() {

      public void onKeyUp(Widget sender, char keyCode, int modifiers) {
        if (keyCode == KeyboardListener.KEY_RIGHT) {
          RateItWidget.this.setUserRating(
            RateItWidget.this.getUserRating() + 1, true);
        } else if (keyCode == KeyboardListener.KEY_LEFT) {
          RateItWidget.this.setUserRating(
            RateItWidget.this.getUserRating() - 1, true);
        } else if (keyCode >= '0' && keyCode <= '9') {
          RateItWidget.this.setUserRating(keyCode - '0', true);
        }
      }
    });
    grid = new Grid(1, maxRating + 1) {
      public boolean clearCell(int row, int column) {
        boolean retValue = super.clearCell(row, column);

        Element td = getCellFormatter().getElement(row, column);
        DOM.setInnerHTML(td, "");
        return retValue;
      }
    };
    grid.setCellSpacing(0);
    grid.setCellPadding(0);
    this.normalImage = normalImage;
    this.ratedImage = ratedImage;
    this.normalZeroImage = normalZeroImage;
    this.ratedZeroImage = ratedZeroImage;
    this.ratingImages = ratingImages;
    this.rating = rating;
    this.userRating = 0;
    setup();
    panel.add(grid);
    setWidget(panel);
    setStyleName("RateItWidget");
  }

  public void setUserRating(int rating) {
    setUserRating(rating, false);
  }

  public int getUserRating() {
    return userRating;
  }

  public boolean isRated() {
    return rated;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
    if (!isRated()) {
      setup();
    }
  }

  public void addChangeListener(ChangeListener listener) {
    if (changeListeners == null) {
      changeListeners = new ChangeListenerCollection();
    }
    changeListeners.add(listener);
  }

  public void removeChangeListener(ChangeListener listener) {
    if (changeListeners != null) {
      changeListeners.remove(listener);
    }
  }

  protected void setUserRating(int rating, boolean fireEvents) {
    if (rating < 0 || rating >= grid.getColumnCount()) {
      return;
    }
    this.userRating = rating;
    drawRating(userRating);
    if (fireEvents) {
      this.rated = true;
      changeListeners.fireChange(this);
    }
  }

  protected void drawRating(int rating) {
    int colCount = grid.getColumnCount();
    int rateCount = Math.min(rating, colCount);
    if (rateCount == 0) {
      ((RatePanel) grid.getWidget(0, 0)).replaceImage(ratedZeroImage);
    } else {
      ((RatePanel) grid.getWidget(0, 0)).replaceImage(normalZeroImage);
    }
    int i;
    for (i = 1; i <= rateCount; i++) {
      ((RatePanel) grid.getWidget(0, i)).replaceImage(ratedImage);
    }
    for (; i < colCount; i++) {
      ((RatePanel) grid.getWidget(0, i)).replaceImage(normalImage);
    }
  }

  protected void setup() {
    final int colCount = grid.getColumnCount();
    boolean ratingImages10 = ratingImages != null && ratingImages.length == 10;
    Image ratingImage = (ratingImages != null && ratingImages.length > 0) ?
      ratingImages[0] : normalImage;
    for (int i = 0; i < colCount; i++) {
      Image img;
      if (i == 0) {
        img = normalZeroImage;
      } else if (i <= rating) {
        img = ratingImage;
      } else if (ratingImages10 && i < rating + 1) {
        int f = (int) ((rating - i + 1) * 10);
        if (f > 0) {
          img = ratingImages[f];
        } else {
          img = normalImage;
        }
      } else {
        img = normalImage;
      }
      final RatePanel panel = new RatePanel(i, img);
      panel.addMouseListener(cellMouseListener);
      panel.addClickListener(cellClickListener);
      grid.setWidget(0, i, panel);
    }
  }
}