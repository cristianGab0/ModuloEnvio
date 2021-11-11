import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OpcionesEnviosComponent } from './opciones-envios.component';

describe('OpcionesEnviosComponent', () => {
  let component: OpcionesEnviosComponent;
  let fixture: ComponentFixture<OpcionesEnviosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OpcionesEnviosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OpcionesEnviosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
