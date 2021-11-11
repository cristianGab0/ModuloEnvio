import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModuloEnviosComponent } from './modulo-envios.component';

describe('ModuloEnviosComponent', () => {
  let component: ModuloEnviosComponent;
  let fixture: ComponentFixture<ModuloEnviosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModuloEnviosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModuloEnviosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
