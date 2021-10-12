import {Injectable} from "@angular/core";
import {Person} from "../../model/person/person";
import {PersonService} from "./person.service";
import {MatTable, MatTableDataSource} from "@angular/material/table";

const ID_TABLE_COLUMN_NAME = 'id';
const LAST_NAME_TABLE_COLUMN_NAME = 'lastName';
const FIRST_NAME_TABLE_COLUMN_NAME = 'firstName';
const PATRONYMIC_TABLE_COLUMN_NAME = 'patronymic';
const BIRTH_DAY_TABLE_COLUMN_NAME = 'birthDay';
const PHONE_TABLE_COLUMN_NAME = 'phone';
const POST_TABLE_COLUMN_NAME = 'post';

@Injectable()
export class PersonTableService {

  displayedColumns: string[] = [
    ID_TABLE_COLUMN_NAME,
    LAST_NAME_TABLE_COLUMN_NAME,
    FIRST_NAME_TABLE_COLUMN_NAME,
    PATRONYMIC_TABLE_COLUMN_NAME,
    BIRTH_DAY_TABLE_COLUMN_NAME,
    PHONE_TABLE_COLUMN_NAME,
    POST_TABLE_COLUMN_NAME
  ]
  dataSource = new MatTableDataSource<Person>();
  // @ts-ignore
  table: MatTable<Person>;

  constructor(private personService: PersonService) {
  }

  refreshTable() {
    this.personService.getAllPersons().subscribe((data: Person[]) => {
      this.dataSource.data = data;
    });
  }
}
