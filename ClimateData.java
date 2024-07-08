import java.util.ArrayList;
import java.util.List;

public class ClimateData {
    private List<String> climateData = new ArrayList<>();

    // Constructor to initialize with data
    public ClimateData() {
        climateData.add("FLOODS\n" +
                "In some landscapes flooding can be a natural part of a yearly cycle providing ecosystem services—the direct and indirect benefits that natural resources provide to people—and supporting livelihoods. But when communities and infrastructure are unable to cope with inundation the resulting flood disaster impacts can be devastating. In fact floods impact more people worldwide than any other disaster and the economic social and environmental impacts are getting worse. By 2050 one study projects the cost of flooding to rise by 11 billion dollars.\n" +
                "Several factors are contributing to the increase in flood risk. These include changes in rainfall storms and temperatures driven by the climate crisis as well as societal factors such as changes in land use and the development of floodplains.\n" +
                "Hard engineering such as dams and seawalls is often the default flood management method. But these structural measures cannot adapt to changing conditions can be expensive to build and can lead to negative social and environmental impacts. Nature-based flood management methods can maximize the benefits of floodwaters while managing and minimizing negative consequences. These methods can be used independently or in combination with hard engineering methods.\n" +
                "(Vernick 2024)");
        climateData.add("STORMS\n" +
                "Storms are impacted by climate change in the same way that some floods are via the effect that higher temperatures have on evaporation and subsequent precipitation. With clouds holding increased amounts of water vapor more powerful storms develop.");
        climateData.add("EARTHQUAKES\n" +
                "The connection between earthquakes and climate change is slightly less straightforward and certainly less influential. Most earthquakes occur when tectonic plates within the Earth’s crust change or move. Many things can lead to this but where climate change comes into play is once again related to water. Earthquakes can be triggered or prevented by variability in stress on a fault between tectonic plates. Stress on these faults is impacted by surface water from rain or snow. When there is heavier rainfall this precipitation and any subsequent flooding increases stress and decreases seismicity. When the season dries up and there’s less water the weight on the Earth’s crust decreases and this can lead to microseismicity.\n" +
                "As of now the majority of the connection between earthquakes and climate change is with microseismicity or tiny earthquakes which have magnitudes of less than zero and are so small that humans can’t feel them. While additional connections can be made such as impacts from pumping groundwater during droughts connections between larger earthquakes and climate change have largely not been proven though the rapid movement of glaciers has also been shown to cause glacial earthquakes.");
        climateData.add("EXTREME TEMPERATURES\n" +
                "Climate change can lead to both extreme high temperatures and extreme low temperatures. The connection with extreme high temperatures is more intuitive — greenhouse gases are being trapped in the atmosphere and this leads to warming. However the connection to extreme low temperatures can be harder for some people to make. Lower temperatures in some regions are a result of the polar vortex being warmer causing it to weaken and dip down further than it normally would bringing with it colder temperatures. This is further exacerbated by impacts to the jet stream that change the pattern of where and when hot and cold temperatures typically occur. These two combined have led to hotter summers and harsher winters in some areas.");
        climateData.add("LANDSLIDES\n" +
                "Landslides are connected to rainfall as well. Due to climate change’s impact on evaporation and precipitation more frequent and intense rainfall events can lead to more landslides.");
        climateData.add("DROUGHTS\n" +
                "On the other side of the water spectrum are droughts though they result from the same process. Droughts are a natural part of the climate cycle but climate change is making them more frequent severe and prolonged. While higher levels of evaporation lead to eventual severe rainfall in some regions this shift means drier conditions due to the loss of the evaporated water which can lead to drought and dried out soils and vegetation. With climate change places that are traditionally dry are becoming drier through the higher levels of evaporation and places that are traditionally wet are becoming wetter through the higher levels of rainfall that result.");
        climateData.add("WILDFIRES\n" +
                "Wildfires are a consequence of the drier conditions caused by climate change in some areas. The wildfire season is much longer than in previous years and the number of wildfires per season has tripled. Severe heat and drought provide fuel for fires through drier soils and vegetation that is more flammable. Additionally due to warmer temperatures snowpacks are melting earlier meaning that forests are drier for longer periods of time and increasingly at risk of fires.");
        climateData.add("VOLCANIC ACTIVITY\n" +
                "Similar to earthquakes volcanic activity has a less direct relationship with climate change. Volcanoes do contribute to changes in Earth’s atmosphere through spewing CO2 aerosols ash and metals into the atmosphere but they have a net cooling effect. This is due to the impact that aerosols have on cooling versus warming.\n" +
                "On the flip side there is some evidence to suggest that climate change could increase eruptions in a similar way that they impact seismic activity through lessening the pressure on the Earth’s surface. In this case this decreased pressure causes more hot magma to come in contact with aquifers which triggers eruptions. Additionally melting glaciers are exposing more volcanoes.");
    }

    // Display climate data
    public void displayClimateData() {
        for (String data : climateData) {
            System.out.println(data);
            System.out.println();
        }
    }

    // Add climate data (Admin only)
    public void addData(String data) {
        climateData.add(data);
    }

    // Edit existing climate data (Admin only)
    public void editData(int index, String newData) {
        if (index >= 0 && index < climateData.size()) {
            climateData.set(index, newData);
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Delete climate data (Admin only)
    public void deleteData(int index) {
        if (index >= 0 && index < climateData.size()) {
            climateData.remove(index);
        } else {
            System.out.println("Invalid index.");
        }
    }

    public List<String> getClimateData() {
        return climateData;
    }
}
