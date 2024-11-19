package net.runelite.client.plugins.microbot.cluesolverv2;

import com.google.inject.Inject;
import net.runelite.client.plugins.microbot.Microbot;
import net.runelite.client.plugins.microbot.cluescrolls.ClueScrollPlugin;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import java.awt.*;

public class ClueSolverOverlay extends Overlay {

    private final ClueSolverPlugin plugin;
    private final ClueScrollPlugin clueScrollPlugin;
    private final ClueSolverScriptV2 clueSolverScriptV2;
    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    public ClueSolverOverlay(ClueSolverPlugin plugin, ClueScrollPlugin clueScrollPlugin, ClueSolverScriptV2 clueSolverScriptV2) {
        this.plugin = plugin;
        this.clueScrollPlugin = clueScrollPlugin;
        this.clueSolverScriptV2 = clueSolverScriptV2;

        setPosition(OverlayPosition.TOP_LEFT);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        panelComponent.getChildren().clear();

        panelComponent.getChildren().add(TitleComponent.builder()
                .text("Clue Solver V2")
                .color(Color.GREEN)
                .build());

        panelComponent.getChildren().add(LineComponent.builder().build());

        if (!Microbot.getPluginManager().isActive(clueScrollPlugin)) {
        panelComponent.getChildren().add(LineComponent.builder()
                .left("Make sure to enable the 'Clue Scroll' plugin!")
                .leftColor(Color.RED)
                .build());
        } else {
            panelComponent.getChildren().add(LineComponent.builder()
                    .left("Clue Scrolls Plugin is Active")
                    .leftColor(Color.GREEN)
                    .build());

        }


        return panelComponent.render(graphics);
    }
}
