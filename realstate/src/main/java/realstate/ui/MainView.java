package realstate.ui;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;

public class MainView extends HorizontalLayout {

    public MainView() {
        RouterLink residentialLink = new RouterLink("Residential", ResidentialView.class);
        RouterLink commercialLink = new RouterLink("Commercial", CommercialView.class);
        RouterLink landLink = new RouterLink("Land", LandView.class);

        // If you want to add icons or other styling, you can wrap the links in buttons
        Button residentialButton = new Button("Residential", VaadinIcon.HOME.create());
        residentialButton.getElement().appendChild(residentialLink.getElement());

        Button commercialButton = new Button("Commercial", VaadinIcon.BUILDING.create());
        commercialButton.getElement().appendChild(commercialLink.getElement());

        Button landButton = new Button("Land", VaadinIcon.GLOBE.create());
        landButton.getElement().appendChild(landLink.getElement());

        add(residentialButton, commercialButton, landButton);
    }
}
