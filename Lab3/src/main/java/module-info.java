module me.salmonmoses.labThree {
	requires javafx.controls;
	requires javafx.fxml;


	opens me.salmonmoses.lab3 to javafx.fxml;
	exports me.salmonmoses.lab3;
}