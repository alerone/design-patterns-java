package shoplab.ejercicios;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SettingsController
 */
@RestController 
public class SettingsController {

    private final ShopSettings settings;
    public SettingsController(ShopSettings settings) {
        this.settings = settings;
    }

    @GetMapping("/settings")
    public ShopSettings getSettings() {
        return settings;
    }
}
