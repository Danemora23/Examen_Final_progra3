insert into pacientes(id, Nombre, Nombredos, Apellido, Apellidodos, edad) values (1, 'Marta', 'Marina', 'Perez', 'Gonzalez', 18);
insert into pacientes(id, Nombre, Nombredos, Apellido, Apellidodos, edad) values (2, 'Daniel', 'Alejandro', 'Portillo', 'Pivaral', 21);
insert into pacientes(id, Nombre, Nombredos, Apellido, Apellidodos, edad) values (3, 'Maria', 'Fernanda', 'Moran', 'Melendez', 22);
insert into citas(id, fecha, hora, paciente, estado, observaciones) values (1, '11/06/2021', '10:00', 'Marta', 'PENDIENTE', 'Emergencia');
insert into citas(id, fecha, hora, paciente, estado, observaciones) values (2, '11/06/2021', '10:30', 'Daniel', 'ACEPTADO', 'Urgente');
insert into citas(id, fecha, hora, paciente, estado, observaciones) values (3, '11/06/2021', '11:00', 'Maria', 'CANCELADO', 'Lesiones leves');