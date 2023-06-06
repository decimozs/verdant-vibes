package hooks;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import components.PlantDescriptionCard;

public class Hooks {

	private boolean toggle = true;
	
	public void HeartReact(JLabel component, int width, int height, int x, int y, String iconPath) {
		Dimension dimension = new Dimension(width, height);
		component.setPreferredSize(dimension);
		component.setMinimumSize(dimension);
		component.setMaximumSize(dimension);
		component.setBounds(x, y, width, height);
		
		component.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(toggle) {
					component.setIcon(new ImageIcon(getClass().getResource(iconPath)));
				}else {
					component.setIcon(null);
				}
				
				toggle = !toggle;
			}
		});
	}
	
	public void SetPlantCard(JPanel panel, JLabel component, String name, String familyName, String categoryName, String price, String descriptionPath, String plantImagePath) {
		component.setText(name);
		component.setText(familyName);
		component.setText(categoryName);
		component.setText(price);
		component.setIcon(new ImageIcon(getClass().getResource(descriptionPath)));
		component.setIcon(new ImageIcon(getClass().getResource(plantImagePath)));
		
		component.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setVisible(true);
			}
		});

	}
	
	public void setPlantItemCardProperties(PlantDescriptionCard plantCard, String name, String description, String family, String category, String price, String image) {
	    plantCard.plantName.setText(name);
	    plantCard.plantDescription.setIcon(new ImageIcon(PlantDescriptionCard.class.getResource(description)));
	    plantCard.familyName.setText(family);
	    plantCard.categoryName.setText(category);
	    plantCard.retailPrice.setText(price);
	    plantCard.plantIcon.setIcon(new ImageIcon(PlantDescriptionCard.class.getResource(image)));
	    plantCard.bg.setIcon(new ImageIcon(PlantDescriptionCard.class.getResource("/resources/plantDescriptionMask.png")));
	}

	
}