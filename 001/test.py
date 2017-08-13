import random
import string

#设定随机种子
random.seed()

#构造需要随机采样的序列
base = string.ascii_uppercase + string.ascii_lowercase + string.digits
#随机采样，长度为16
code_list = random.sample(base, 16)
#构造生成的激活码
act_code = ''.join(code_list)
#打印生成的激活码
print(act_code)