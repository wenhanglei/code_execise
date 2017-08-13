import sys
from PIL import Image, ImageFont, ImageDraw

def addNumber(image, number):
    try:
        (im_width, im_height) = image.size         # 获得图片的大小
        if isinstance(number, int):
            num_str = '%03d' % number
        else:
            number = int(number)
            num_str = '%03d' % int(number)         #获得需要显示的数字字符

        text = ImageDraw.Draw(image,"RGBA")        #获得绘画对象
        font = ImageFont.truetype("arial.ttf", 20) #字符的字体及格式
        (t_width, t_height) = text.textsize(num_str, font) #获得字符的大小
        x_pos = im_width - t_width - 5            #设置字符的坐标
        y_pos = 0
        text.text((x_pos, y_pos), num_str, 'red', font) #绘制字符
        del text                                    #关闭绘制对象
    except:
        print(sys.exc_info()[0])

if __name__ == '__main__':
    im = Image.open('myphoto.jpg')
    addNumber(im, "35")
    im.save('text.jpg')