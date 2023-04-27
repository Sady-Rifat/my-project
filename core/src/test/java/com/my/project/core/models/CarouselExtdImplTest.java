package com.my.project.core.models;

import com.adobe.cq.wcm.core.components.models.Carousel;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import junitx.util.PrivateAccessor;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
public class CarouselExtdImplTest {
    private final AemContext aemContext = new AemContext(ResourceResolverType.JCR_MOCK);
    private final CarouselExtdImpl carouselExtd = Mockito.spy(CarouselExtdImpl.class);

    @Mock
    private Carousel coreCarousel;

    @BeforeEach
    void init() throws NoSuchFieldException {
        PrivateAccessor.setField(carouselExtd, "coreCarousel", coreCarousel);
    }

    @Test
    public void idTest() {
        when(coreCarousel.getId()).thenReturn("1234");
        assertNotNull(carouselExtd.getId());
    }
}
