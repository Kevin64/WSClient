package wsclient;

/**
 *
 * @author Kevin
 */
public class WSClient {
    
    private String city, country, weather, currency;
    
    public WSClient() {
        
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void XMLHandler() {
        try {
            weather = getWeather(city, country) + "\n";
            String tofind = "<?xml version=\"1.0\" encoding=\"utf-16\"?>";
            weather = weather.replace(tofind, "<global>");

            if(weather.contains("Data Not Found")) 
                weather = "<global>";

            currency = getGMTbyCountry(country) + "\n" + getCurrencyByCountry(country) + "\n" + getISD(country)+"\n"+"</global>";

            CreateXML x1 = new CreateXML(weather+currency);            
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    private String getWeather(java.lang.String cityName, java.lang.String countryName) {
        net.webservicex.GlobalWeather service = new net.webservicex.GlobalWeather();
        net.webservicex.GlobalWeatherSoap port = service.getGlobalWeatherSoap();
        return port.getWeather(cityName, countryName);
    }

    private String getGMTbyCountry(java.lang.String countryName) {
        net.webservicex.Country service = new net.webservicex.Country();
        net.webservicex.CountrySoap port = service.getCountrySoap();
        return port.getGMTbyCountry(countryName);
    }

    private String getCurrencyByCountry(java.lang.String countryName) {
        net.webservicex.Country service = new net.webservicex.Country();
        net.webservicex.CountrySoap port = service.getCountrySoap();
        return port.getCurrencyByCountry(countryName);
    }

    private String getISD(java.lang.String countryName) {
        net.webservicex.Country service = new net.webservicex.Country();
        net.webservicex.CountrySoap port = service.getCountrySoap();
        return port.getISD(countryName);
    }
    
}
