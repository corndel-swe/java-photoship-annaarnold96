package com.corndel.photoship.lib;

import java.util.List;

public class Pixels {

    /**
     * Removes the red component from the RGB list by setting it to 0.
     * <p>
     * This filter removes the red channel entirely, making the image appear
     * more green/blue.
     *
     * @param rgb A list containing the red, green, and blue values as integers.
     * @return The RGB list with the red value set to 0.
     */
    public static List<Integer> stripRed(List<Integer> rgb) {
        // Set the red value (index 0) to 0
        rgb.set(0, 0);
        return rgb;
    }

    /**
     * Removes the green component from the RGB list by setting it to 0.
     * <p>
     * This filter removes the green channel entirely, making the image appear
     * more red/blue.
     *
     * @param rgb A list containing the red, green, and blue values as integers.
     * @return The RGB list with the green value set to 0.
     */
    public static List<Integer> stripGreen(List<Integer> rgb) {
        // Set the green value (index 1) to 0
        rgb.set(1, 0);
        return rgb;
    }

    /**
     * Removes the blue component from the RGB list by setting it to 0.
     * <p>
     * This filter removes the blue channel entirely, making the image appear
     * more red/green.
     *
     * @param rgb A list containing the red, green, and blue values as integers.
     * @return The RGB list with the blue value set to 0.
     */
    public static List<Integer> stripBlue(List<Integer> rgb) {
        // Set the blue value (index 2) to 0
        rgb.set(2, 0);
        return rgb;
    }

    /**
     * Inverts the RGB values by subtracting each from 255.
     * <p>
     * Inversion makes colors their opposite. For example, bright colors become
     * dark,
     * and dark colors become bright.
     *
     * @param rgb A list containing the red, green, and blue values as integers.
     * @return The RGB list with inverted colors.
     */
    public static List<Integer> invert(List<Integer> rgb) {
        // Invert each color value by subtracting it from 255
        //    rgb.set(0, 255 - rgb.get(0));
        //  rgb.set(1, 255 - rgb.get(1));
        //rgb.set(2, 255 - rgb.get(2));
        List<Integer> invertedRgb = rgb.stream().map(x -> 255 - x).toList();
        return invertedRgb;
    }

    /**
     * Converts the image to grayscale by setting each color to the average of the
     * RGB components.
     * <p>
     * Grayscale removes all color information, leaving the image in shades of gray.
     *
     * @param rgb A list containing the red, green, and blue values as integers.
     * @return The RGB list with the grayscale values applied.
     */
    public static List<Integer> grayscale(List<Integer> rgb) {
        // Calculate the average of the red, green, and blue values
        Integer average = (rgb.get(0) + rgb.get(1) + rgb.get(2)) / 3;
        // Set all components to the average value to create a grayscale effect
        List<Integer> greyscale = rgb.stream().map(x -> average).toList();
        return greyscale;
    }

    /**
     * Converts the image to black and white by setting all colors to either 0 or
     * 255 based on their average.
     * <p>
     * If the average of the RGB values is less than 128, the pixel is set to black
     * (0).
     * Otherwise, the pixel is set to white (255).
     *
     * @param rgb A list containing the red, green, and blue values as integers.
     * @return The RGB list with the black and white values applied.
     */
    public static List<Integer> blackAndWhite(List<Integer> rgb) {
        // Calculate the average of the red, green, and blue values
        Integer BWaverage = (rgb.get(0) + rgb.get(1) + rgb.get(2)) / 3;
        // If the average is below 128, set all values to 0 (black); otherwise, set them

        if (BWaverage < 128) {
            rgb.set(0, 0);
            rgb.set(1, 0);
            rgb.set(2, 0);
            //bWrgb = rgb.stream().map(x -> 0).toList();
        } else {
            //bWrgb = rgb.stream().map(x -> 255).toList();
            rgb.set(0, 255);
            rgb.set(1, 255);
            rgb.set(2, 255);
        }
        // to 255 (white)
        return rgb;
    }

    /**
     * Isolates a specific color channel (red, green, or blue).
     * <p>
     * This filter keeps the value of the specified color channel and sets
     * the other two channels to 0. For example, if the red channel is chosen,
     * the green and blue channels will be set to 0.
     *
     * @param rgb   A list containing the red, green, and blue values as integers.
     * @param color The color channel to keep ('r', 'g', or 'b').
     * @return The RGB list with only the specified color channel.
     */
    public static List<Integer> colorChannel(List<Integer> rgb, char color) {
        // TODO
        if (color == 'r') {
            rgb.set(1, 0);
            rgb.set(2, 0);
        } else if (color == 'g') {
            rgb.set(0, 0);
            rgb.set(2, 0);
        } else if (color == 'b') {
            rgb.set(0, 0);
            rgb.set(1, 0);

        }
        return rgb;
    }

    /**
     * Applies a sepia tone filter to the RGB list.
     * <p>
     * Sepia gives the image a warm, brownish tone, which is often seen in old
     * photographs.
     * The transformation is applied using the following formulas:
     * - New Red = (0.393 * R) + (0.769 * G) + (0.189 * B)
     * - New Green = (0.349 * R) + (0.686 * G) + (0.168 * B)
     * - New Blue = (0.272 * R) + (0.534 * G) + (0.131 * B)
     *
     * @param rgb A list containing the red, green, and blue values as integers.
     * @return The RGB list with the sepia filter applied.
     */
    public static List<Integer> sepia(List<Integer> rgb) {
        // Extract the original red, green, and blue values
        int redColour = rgb.get(0);
        int greenColour = rgb.get(1);
        int blueColour = rgb.get(2);

        // Apply the sepia tone formula to each color component
        double newRed = (0.393 * redColour) + (0.769 * greenColour) + (0.189 * blueColour);
        double newGreen = (0.349 * redColour) + (0.686 * greenColour) + (0.168 * blueColour);
        double newBlue = (0.272 * redColour) + (0.534 * greenColour) + (0.131 * blueColour);
        // Update the RGB list with the new sepia values
        int intRed = (int) Math.min(Math.max(newRed, 0), 255);
        int intGreen = (int) Math.min(Math.max(newGreen, 0), 255);
        int intBlue = (int) Math.min(Math.max(newBlue, 0), 255);

        rgb.set(0, intRed);
        rgb.set(1, intGreen);
        rgb.set(2, intBlue);

        return rgb;
    }

    /**
     * Adjusts the brightness of an image by adding or subtracting a value from each
     * color channel.
     * <p>
     * Brightness is adjusted by simply adding the brightness value to each color
     * component.
     * The resulting values are clamped to stay within the valid RGB range (0-255).
     *
     * @param rgb        A list containing the red, green, and blue values as
     *                   integers.
     * @param brightness The brightness adjustment value. Positive values increase
     *                   brightness, negative values decrease it.
     * @return The RGB list with the adjusted brightness.
     */
    public static List<Integer> adjustBrightness(List<Integer> rgb, int brightness) {
        // Adjust the red, green, and blue values and clamp them between 0 and 255
        int brightRed = Math.min(Math.max((rgb.get(0) + brightness), 0), 255);
        int brightGreen = Math.min(Math.max((rgb.get(1) + brightness), 0), 255);
        int brightBlue = Math.min(Math.max((rgb.get(2) + brightness), 0), 255);
        // Update the RGB list with the new brightness-adjusted values

        rgb.set(0, brightRed);
        rgb.set(1, brightGreen);
        rgb.set(2, brightBlue);

        return rgb;
    }
}
