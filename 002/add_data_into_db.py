from mysql import connector

cnx = connector.connect(user='root',
                        password='712342',
                        host='localhost',
                        database='mysql')
cnx.database = 'mytest'
cursor = cnx.cursor()
add_account = "insert into account (name, balance) value (" \
              "'chengliu', 2000);"
cursor.execute(add_account)
cursor.close()
cnx.close()


