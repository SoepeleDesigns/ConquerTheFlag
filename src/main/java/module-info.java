module conquertheflag {
    requires hanyaeger;
    requires com.google.guice;

    exports ConquerTheFlag;

    opens audio;
    opens backgrounds;
    opens sprites;
    exports ConquerTheFlag.entities.map;
    exports ConquerTheFlag.entities;
    exports ConquerTheFlag.entities.lever;

}
