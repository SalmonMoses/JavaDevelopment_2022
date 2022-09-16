module me.salmonmoses.labThree {
	requires javafx.controls;

	opens me.salmonmoses.lab3 to javafx.fxml;
	exports me.salmonmoses.lab3;
}