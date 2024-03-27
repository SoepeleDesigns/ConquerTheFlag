module conquertheflag {
    requires hanyaeger;
    requires com.google.guice;

    exports com.github.hanyaeger.tutorial;

    opens audio;
    opens backgrounds;
    opens sprites;
    exports com.github.hanyaeger.tutorial.entities.map;
    exports com.github.hanyaeger.tutorial.entities;
    exports com.github.hanyaeger.tutorial.entities.lever;

}
