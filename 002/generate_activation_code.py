#coding:utf-8
import string
import random

def activation_code(number, length):
    # 设定随机种子
    random.seed()

    #创建激活码list
    act_codes = []
    # 构造需要随机采样的序列
    base = string.ascii_uppercase + string.ascii_lowercase + string.digits
    # 随机采样，长度为16
    code_list = [random.sample(base, length) for i in range(number)]
    # 构造生成的激活码
    for codes in code_list:
        act_code = ''.join(codes)
        act_codes.append(act_code)

    # 返回生成的所有激活码
    return act_codes


if __name__ == '__main__':
    codes = activation_code(5, 16)
    for code in codes:
        print(code)