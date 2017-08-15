from mysql import connector

cnx = connector.connect(user='root', password='712342',
                        host='localhost', database='mysql')
cnx.database = 'mytest'
cursor = cnx.cursor()

cursor.execute('select * from account;')

for (id, name, balance) in cursor:
    print(name)

cursor.close()
cnx.close()
