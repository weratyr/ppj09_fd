package ppj09.gwt.swapweb.client.gui;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.event.ButtonListener;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.Label;
import com.gwtext.client.widgets.menu.Menu;

import ppj09.gwt.swapweb.client.SwapWeb;
import ppj09.gwt.swapweb.client.datatype.OfferSearchResult;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandler;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandlerAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class OfferSearchResultView extends Composite implements SearchResultView {
	private OfferSearchResult offerSearchResult;
	
	public OfferSearchResultView(final SearchResult offerSearchResult) {
		final SearchHandlerAsync sh = GWT.create(SearchHandler.class);
		this.offerSearchResult = (OfferSearchResult) offerSearchResult;
		Panel offerPanel = new Panel();
		offerPanel.setTitle("Angebot von " + this.offerSearchResult.getOfferedBy());
		offerPanel.setWidth("90%");
	
		for (SearchResult articleSearchResult : this.offerSearchResult.getArticles())
			offerPanel.add((ArticleSearchResultView) articleSearchResult.getView());
		
		//HorizontalPanel horizontalButtonPanel = new HorizontalPanel();
		ToolbarButton annehmen = new ToolbarButton("annehmen");
		annehmen.addListener(new ButtonListenerAdapter() {
			public void onClick(Button button, EventObject e) {
				sh.acceptOffer(((OfferSearchResult)offerSearchResult).getId(), 
						new AsyncCallback<Integer>(){
					public void onFailure(Throwable caught) {
						caught.printStackTrace();
					}
					public void onSuccess(Integer result) {
						if (result==1)
							System.out.println("Angebot erfolgreich angenommen.");
						else 
							System.out.println("Fehlgeschlagen!");
					}
				});
			}
		});
		ToolbarButton ablehnen = new ToolbarButton("ablehnen");
		ablehnen.addListener(new ButtonListenerAdapter(){
			public void onClick(Button button, EventObject e) {
				sh.declineOffer(((OfferSearchResult)offerSearchResult).getId(), 
						new AsyncCallback<Integer>(){
					public void onFailure(Throwable caught) {
						caught.printStackTrace();
					}
					public void onSuccess(Integer result) {
						if (result==1)
							System.out.println("Angebot erfolgreich abgelehnt.");
						else 
							System.out.println("Fehlgeschlagen!");
					}
				});
			}
		});
		
		/*
		 * Wenn der user sein eigenes Profil ansieht hat er die Möglichkeit
		 * Angebote anzunehmen und abzulehnen.
		 */
		if (this.offerSearchResult.getOfferedTo().equals(SwapWeb.getUserNameFromSession())) {
			Toolbar buttonToolbar = new Toolbar();
			buttonToolbar.addButton(annehmen);
			buttonToolbar.addButton(ablehnen);
			offerPanel.setBottomToolbar(buttonToolbar);
			//offerPanel.add(horizontalButtonPanel);
		} else {
			System.out.println(this.offerSearchResult.getOfferedTo() + " != " + SwapWeb.getUserNameFromSession());
		}
		
		offerPanel.doLayout();
		initWidget(offerPanel);
	}
}
