export class Tab {
  id: number;
  title: string;
  type: string;

  constructor(id: number, title: string, type: string) {
    this.id = id;
    this.title = title;
    this.type = type;
  }
}
