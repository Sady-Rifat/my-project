package com.my.project.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.wcm.core.components.models.Carousel;
import com.adobe.cq.wcm.core.components.models.ListItem;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import java.util.List;

@Model(adaptables = SlingHttpServletRequest.class, adapters = {CarouselExtdImpl.class, ComponentExporter.class},
        resourceType = CarouselExtdImpl.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CarouselExtdImpl implements CarouselExtd {
    public static final String RESOURCE_TYPE = "my-project/components/carousel";

    @Self
    private Carousel coreCarousel;

    @Override
    public List<ListItem> getItems() {
        // Write your Own Logic Here
        return coreCarousel.getItems();
    }

    @Override
    public boolean getAutoplay() {
        return coreCarousel.getAutoplay();
    }

    @Override
    public Long getDelay() {
        return coreCarousel.getDelay();
    }

    @Override
    public boolean getAutopauseDisabled() {
        return coreCarousel.getAutopauseDisabled();
    }

    @Override
    public String getAccessibilityLabel() {
        return coreCarousel.getAccessibilityLabel();
    }

    @Override
    public String getAccessibilityPrevious() {
        return coreCarousel.getAccessibilityPrevious();
    }

    @Override
    public String getAccessibilityNext() {
        return coreCarousel.getAccessibilityNext();
    }

    @Override
    public String getAccessibilityPlay() {
        return coreCarousel.getAccessibilityPlay();
    }

    @Override
    public String getAccessibilityPause() {
        return coreCarousel.getAccessibilityPause();
    }

    @Override
    public String getAccessibilityTablist() {
        return coreCarousel.getAccessibilityTablist();
    }

    @Override
    public boolean getAccessibilityAutoItemTitles() {
        return coreCarousel.getAccessibilityAutoItemTitles();
    }

    @Override
    public boolean isControlsPrepended() {
        return coreCarousel.isControlsPrepended();
    }

    @Override
    public String getId() {
        return coreCarousel.getId();
    }
}