from mysql import connector
from generate_activation_code import activation_code

#获得mysql数据库连接
cnx = connector.connect(user='root',
                        password='****',
                        host='localhost',
                        database='test')
#创建光标对象
cursor = cnx.cursor()
#生成10个长度为16的激活码
act_codes = activation_code(10, 16)

for act_code in act_codes:
    #构造插入语句
    insert = "insert into codes values ('%s');"
    #添加激活码到数据库中
    cursor.execute(insert % act_code)
    #提交事务
    cnx.commit()

#关闭光标
cursor.close()
#关闭连接
cnx.close()
