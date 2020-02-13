package main.java.Impl.concept.Patterns;

public class VehicleBuilder {

    private VehicleBuilder(VehicleBuilder.Builder builder) {

    }

    public static class Builder {
        String color;
        String model;

        public Builder withColor(String color) {
            this.color = color;
            return this;
        }

        public Builder withModel(String model) {
            this.model = model;
            return this;
        }

        public VehicleBuilder build(){
            return new VehicleBuilder(this);
        }
    }

}
