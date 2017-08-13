from PIL import Image, ImageDraw, ImageFont

im = Image.open('myphoto.jpg')
im_size = im.size
text = ImageDraw.Draw(im, "RGBA")
font = ImageFont.truetype("arial.ttf", 40)
font_size = text.textsize('5', font)
x_pos = im_size[0] - font_size[0]-10
y_pos = 0
print("image_size: ", im_size)
print("font_size: ", font_size)
print("image_position: ", (x_pos, y_pos))
text.text((x_pos, y_pos),'5', 'red',font)
del text
im.save('text.jpg')