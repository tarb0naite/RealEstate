package realstate.ui;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.Image;
import realstate.utils.DataLoader;
import realstate.ui.Property;

import java.util.List;

@Route("residential")
public class ResidentialView extends VerticalLayout {

    public ResidentialView() {
        List<Property> properties = DataLoader.loadProperties("path_to_json");
        properties.stream()
                .filter(p -> p.getType().equals("Residential"))
                .forEach(p -> add(createPropertyComponent(p)));
    }

    private VerticalLayout createPropertyComponent(Property property) {
        VerticalLayout layout = new VerticalLayout();
        Span priceSpan = new Span("Price: " + property.getPrice());
        Span sizeSpan = new Span("Size: " + property.getSize());
        layout.add(new Span(property.getLocation()), priceSpan, sizeSpan);
        property.getPhotos().forEach(photo -> layout.add(new Image(photo, "No Image")));
        return layout;
    }
}
