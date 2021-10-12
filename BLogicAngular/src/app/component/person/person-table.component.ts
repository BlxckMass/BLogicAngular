import {Component, ViewChild} from "@angular/core";
import {PersonService} from "../../service/person/person.service";
import {TabService} from "../../service/tab/tab.service";
import {PersonTableService} from "../../service/person/person-table.service";
import {MatTable} from "@angular/material/table";
import {Person} from "../../model/person/person";

@Component({
  selector: 'person-table',
  templateUrl: '../../view/person/person-table.component.html',
  styleUrls: ['../../css/table/person/person-table.component.css']
})
export class PersonTableComponent {

  // @ts-ignore
  @ViewChild(MatTable) table: MatTable<Person>;

  constructor(private personTableService: PersonTableService,
              private personService: PersonService,
              private tabService: TabService) {
  }

  ngOnInit() {
    this.personTableService.table = this.table;
    this.personTableService.refreshTable();
  }

  getDataSource() {
    return this.personTableService.dataSource;
  }

  getDisplayedColumns() {
    return this.personTableService.displayedColumns;
  }

  clickOnAddPerson() {
    this.tabService.addTabForNodeType(Math.random(), 'Добавление сотрудника', 'AddPerson');
  }

  clickOnRow(row: any) {
    this.tabService.addTabForNodeType(row.person.id, row.person.lastName, 'UpdatePerson');
  }
}
