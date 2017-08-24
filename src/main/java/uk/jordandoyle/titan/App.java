package uk.jordandoyle.titan;

import com.google.common.eventbus.EventBus;
import com.google.inject.Guice;
import com.google.inject.Injector;
import uk.jordandoyle.titan.service.TitanService;

/**
 * Hello world!
 *
 */
public class App {
    public static final EventBus EVENT_BUS = new EventBus();

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Injector injector = Guice.createInjector(new TitanModule());

        TitanService service = injector.getInstance(TitanService.class);
        service.run();
    }
}
