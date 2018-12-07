from PIL import Image

'''
heavily borrowed from https://github.com/kelvins/steganography/blob/master/steganography.py
'''
def int_to_bin(rgb):
    """
    Convert an integer tuple to a binary (string) tuple.
    :param rgb: An integer tuple (e.g. (220, 110, 96))
    :return: A string tuple (e.g. ("00101010", "11101011", "00010110"))
    """
    r, g, b = rgb
    return ('{0:08b}'.format(r),
            '{0:08b}'.format(g),
            '{0:08b}'.format(b))

def bin_to_int(rgb):
        """Convert a binary (string) tuple to an integer tuple.
        :param rgb: A string tuple (e.g. ("00101010", "11101011", "00010110"))
        :return: Return an int tuple (e.g. (220, 110, 96))
        """
        r, g, b = rgb
        return (int(r, 2),
                int(g, 2),
                int(b, 2))

img = Image.open("input/input-pokemon-jakt.png")
pixel_map = img.load()

# Create the new image and load the pixel map
new_image = Image.new(img.mode, img.size)
pixels_new = new_image.load()

# Tuple used to store the image original size
original_size = img.size

for i in range(img.size[0]):
    for j in range(img.size[1]):
        # Get the RGB (as a string tuple) from the current pixel
        r, g, b = int_to_bin(pixel_map[i, j])

        # Extract the last 4 bits (corresponding to the hidden image)
        # Concatenate 4 zero bits because we are working with 8 bit values
        rgb = (r[4:] + "0000",
               g[4:] + "0000",
               b[4:] + "0000")
        # Convert it to an integer tuple
        pixels_new[i, j] = bin_to_int(rgb)

        # If this is a 'valid' position, store it
        # as the last valid position
        if pixels_new[i, j] != (0, 0, 0):
            original_size = (i + 1, j + 1)

# Crop the image based on the 'valid' pixels
new_image = new_image.crop((0, 0, original_size[0], original_size[1]))
new_image.format = "PNG"
new_image.show()
